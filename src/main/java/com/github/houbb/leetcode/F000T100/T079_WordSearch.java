package com.github.houbb.leetcode.F000T100;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T079_WordSearch {

    public boolean exist(char[][] board, String word) {
        System.out.println("word: " +word);
        // 统一转换，可以避免 charAt 的越界校验
        char[] chars = word.toCharArray();

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(search(board, chars, visited, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    // 实际上核心思想还是回溯
    // index 从零开始
    private boolean search(char[][] board, char[] chars,
                           boolean[][] visited,
                           int i, int j, int index) {
        // 终止条件
        if(index == chars.length) {
            return true;
        }

        if(i >= board.length || i < 0
                || j >= board[i].length || j < 0
                || board[i][j] != chars[index]
                || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        // 上下左右
        if(search(board, chars, visited, i-1, j, index+1) ||
                search(board, chars, visited,i+1, j, index+1) ||
                search(board, chars, visited, i, j-1, index+1) ||
                search(board, chars, visited, i, j+1, index+1)){
            return true;
        }

        // 回溯
        visited[i][j] = false;
        return false;
    }



}
