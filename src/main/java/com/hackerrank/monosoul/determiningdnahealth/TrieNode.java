package com.hackerrank.monosoul.determiningdnahealth;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class TrieNode {
    private boolean isWord = false;
    private final boolean isRoot;
    private final Character character;
    private final Map<Character, TrieNode> children = new TreeMap<>();
    private TrieNode suffix = null;
    private TrieNode dictSuffix = null;
    private final TrieNode parent;

    TrieNode() {
        this.isRoot = true;
        this.character = null;
        this.parent = null;
    }

    private TrieNode(final Character character, final TrieNode parent) {
        this.isRoot = false;
        this.character = character;
        this.parent = parent;
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
            TrieNode root = getRoot(this);
            suffix = root.getChild(character);
            if (suffix == null) {
                suffix = root;
            }
        }

        return suffix;
    }

    public Optional<TrieNode> getDictSuffix() {
        TrieNode suffix = getSuffix();
        while(!suffix.isRoot() && !suffix.isWord()) {
            suffix = suffix.getSuffix();
        }

        if (suffix.isWord()) {
            return of(suffix);
        }

        return empty();
    }

    private TrieNode getRoot(final TrieNode node) {
        TrieNode curNode = node;
        while(!curNode.isRoot()) {
            curNode = curNode.parent;
        }

        return curNode;
    }

    public TrieNode getParent() {
        return parent;
    }

    public TrieNode createOrGetChild(final Character character, final TrieNode parent) {
        TrieNode node = children.get(character);
        if (node == null) {
            node = new TrieNode(character, parent);
            children.put(character, node);
        }

        return node;
    }

    public TrieNode getChild(final Character character) {
        return children.get(character);
    }
}
