package com.hackerrank.monosoul.determiningdnahealth;

import java.util.*;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class Trie {
    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public Trie addWord(final String word) {
        TrieNode curNode = root;

        final int last = word.length() - 1;
        for (int i = 0; i <= last; i++) {
            final char curChar = word.charAt(i);
            curNode = curNode.createOrGetChild(curChar);

            if (i == last) {
                curNode.setWord(true);
            }
        }

        return this;
    }

    public Trie addWords(final Iterable<String> words) {
        words.forEach(this::addWord);

        return this;
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

    public Map<String, Integer> matches(final String word) {
        TrieNode curNode = root;
        final Map<String, Integer> result = new HashMap<>();

        final int last = word.length() - 1;
        for (int i = 0; i <= last; i++) {
            final char curChar = word.charAt(i);

            curNode = goTo(curNode, curChar);

            if (curNode.isWord()) {
                incrementMatches(result, curNode.getMatchingString().toString());
            }

            while (!curNode.getDictSuffix().isRoot()) {
                curNode = curNode.getDictSuffix();
                if (curNode.isWord()) {
                    incrementMatches(result, curNode.getMatchingString().toString());
                }
            }
        }

        return result;
    }

    private void incrementMatches(final Map<String, Integer> map, final String matchingString) {
        if (!map.containsKey(matchingString)) {
            map.put(matchingString, 0);
        }
        map.put(matchingString, map.get(matchingString) + 1);
    }

    private TrieNode goTo(final TrieNode node, final char goToChar) {
        final TrieNode goToNode = node.getChild(goToChar);
        if (node.isRoot() && root.getChild(goToChar) == null) return root;
        if (goToNode == null || !goToNode.isWord()) {
            return goTo(node.getSuffix(), goToChar);
        }
        return goToNode;
    }
}
