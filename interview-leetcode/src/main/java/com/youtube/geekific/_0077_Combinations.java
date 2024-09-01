/*
 * MIT License
 *
 * Copyright (c) 2023 Geekific (https://www.youtube.com/c/Geekific)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice, Geekific's channel link and this permission notice
 * shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.youtube.geekific;

import java.util.ArrayList;
import java.util.List;

/*
 * Video Reference: https://youtu.be/mZ8Qhv-6WtQ
 * LeetCode Reference: https://leetcode.com/problems/combinations/
 */
public class _0077_Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<>(), n, k, 1);
        return combinations;
    }

    private void backtrack(List<List<Integer>> combinations, List<Integer> currentComb, int n, int k, int start) {
        if (currentComb.size() == k) {
            combinations.add(new ArrayList<>(currentComb));
            return;
        }
        for (int currElement = start; currElement <= n; currElement++) { // Optimal: currElement <= n - (k - currentComb.size()) + 1
            currentComb.add(currElement);
            backtrack(combinations, currentComb, n, k, currElement + 1);
            currentComb.remove(currentComb.size() - 1);
        }
    }

}
