package com.syun.pro02;

/**
 * @description:
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-18 21:45
 */

public class TextEditor {

    private SpellChecker spellChecker;

    private String name;

    public TextEditor(SpellChecker spellChecker) {
        System.out.println("Inside TextEditor constructor");
        this.spellChecker = spellChecker;
    }

    public TextEditor(SpellChecker spellChecker, String name) {
        this.spellChecker = spellChecker;
        this.name = name;
    }

    public TextEditor() {

    }

    public void spellCheck(){
        spellChecker.checkSpelling();
        System.out.println("name: " + name);
    }


    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TextEditor{" +
                "spellChecker=" + spellChecker +
                ", name='" + name + '\'' +
                '}';
    }
}
