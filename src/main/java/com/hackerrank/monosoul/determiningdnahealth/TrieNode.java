package com.hackerrank.monosoul.determiningdnahealth;

import java.util.Map;
import java.util.TreeMap;


public class TrieNode {
    private boolean isWord = false;
    private final boolean isRoot;
    private final Character character;
    private final Map<Character, TrieNode> children = new TreeMap<>();
    private final CharSequence matchingString;
    private final TrieNode parent;
    private final TrieNode root;

    private TrieNode suffix = null;
    private TrieNode dictSuffix = null;
    private boolean dictSuffixCalculated = false;

    TrieNode() {
        this.isRoot = true;
        this.character = null;
        this.parent = null;
        this.matchingString = null;
        this.root = this;
    }

    private TrieNode(
            final CharSequence matchingString, final Character character, final TrieNode root, final TrieNode parent
    ) {
        this.isRoot = false;
        this.character = character;
        this.parent = parent;
        this.matchingString = matchingString;
        this.root = root;
    }

    public boolean isWord() {
        return isWord;
    }

    public TrieNode setWord(boolean word) {
        if (isRoot) throw new UnsupportedOperationException("This is root node!");
        isWord = word;
        return this;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public Character getCharacter() {
        return character;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public TrieNode getSuffix() {
        if (suffix != null) return suffix;

        if (isRoot()) {
            suffix = this;
            return suffix;
        }
        if (parent.isRoot()) {
            suffix = parent;
            return suffix;
        }

        suffix = parent.getSuffix().getChild(character);
        if (suffix == null) {
            suffix = root.getChild(character);
            if (suffix == null) {
                suffix = root;
            }
        }

        return suffix;
    }

    public TrieNode getDictSuffix() {
        if (dictSuffixCalculated) return dictSuffix;

        TrieNode suffix = getSuffix();
        while (!suffix.isRoot() && !suffix.isWord()) {
            suffix = suffix.getSuffix();
        }

        if (suffix.isWord()) {
            dictSuffix = suffix;
        } else {
            dictSuffix = root;
        }
        dictSuffixCalculated = true;

        return dictSuffix;
    }

    public CharSequence getMatchingString() {
        return matchingString;
    }

    public TrieNode getParent() {
        return parent;
    }

    public TrieNode createOrGetChild(final Character character) {
        TrieNode node = children.get(character);
        final StringBuilder sb = (matchingString == null ? new StringBuilder() : new StringBuilder(matchingString))
                .append(character);

        if (node == null) {
            node = new TrieNode(sb, character, root, this);
            children.put(character, node);
        }

        return node;
    }

    public TrieNode getChild(final Character character) {
        return children.get(character);
    }
}
