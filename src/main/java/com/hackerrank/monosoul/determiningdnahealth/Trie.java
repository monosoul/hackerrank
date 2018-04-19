package com.hackerrank.monosoul.determiningdnahealth;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class Trie {
    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void addWord(final String word) {
        TrieNode curNode = root;

        final int last = word.length() - 1;
        for (int i = 0; i <= last; i++) {
            final char curChar = word.charAt(i);
            curNode = curNode.createOrGetChild(curChar, curNode);

            if (i == last) {
                curNode.setWord(true);
            }
        }
    }

    public boolean containsWord(final String word) {
        final Optional<TrieNode> node = findNode(word);
        return node.isPresent() && node.get().isWord();
    }

    public Optional<TrieNode> findNode(final String word) {
        TrieNode curNode = root;

        final int last = word.length() - 1;
        for (int i = 0; i <= last; i++) {
            final char curChar = word.charAt(i);
            curNode = curNode.getChild(curChar);

            if (curNode == null) return empty();
        }

        return of(curNode);
    }
}
