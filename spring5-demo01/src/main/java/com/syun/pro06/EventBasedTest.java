package com.syun.pro06;

import com.sun.source.tree.AssertTree;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description: 模仿用户在 GUI 中的操作
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-04-09 21:40
 */
public class EventBasedTest {

    @Test
    public void test(){

        Mouse mouse = new Mouse();

        mouse.addListener((mouse1 -> {
            System.out.println("listener#1 called");
            mouse1.addListenerCallback();
        }));

        mouse.addListener(mouse1 -> {
            System.out.println("Listener#2 called");
            mouse1.addListenerCallback();
        });

        mouse.click();



    }


    class Mouse {
        private List<mouseListener> mouseListeners = new CopyOnWriteArrayList<>();
        private int listenerCallbacks = 0;

        public void addListenerCallback(){
            listenerCallbacks++;
        }

        public int getListenerCallbacks(){
            return listenerCallbacks;
        }

        public void addListener(mouseListener listener) {
            mouseListeners.add(listener);

        }

        public void click(){
            System.out.println("Clicked !");
            mouseListeners.stream().forEach(p -> p.onClick(this));
        }

    }

    interface mouseListener {
        void onClick(Mouse mouse);
    }


}
