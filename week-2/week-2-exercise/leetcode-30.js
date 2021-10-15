/**
 * 題目：串联所有单词的子串 (Hard)
 */
/**
 * @param {string} s
 * @param {string[]} words
 * @return {number[]}
 */
 var findSubstring = function(s, words) {
    let wordLength = words[0].length;
    let tot = 0;
    for(const word of words) {
        tot += word.length;
    }
    let wordMap = {};
    for(let i = 0; i < words.length; i++) {
        if(words[i] in wordMap) {
            wordMap[words[i]]++;
        } else {
            wordMap[words[i]] = 1;
        }
    }
    let ans = []
    for(let i = 0; i < s.length; i++) {
        let potentialSubString = s.substring(i, i + tot);
        if(potentialSubString.length == tot) {
            if(valid(potentialSubString, wordMap, wordLength)) {
                ans.push(i);
            }
        }
        
    }
    return ans;
};

function valid(potentialSubString, wordMap, wordLength) {
    let map = {}
    for(let i = 0; i < potentialSubString.length; i += wordLength) {
        let word = potentialSubString.substring(i, i + wordLength); 
        if(word in map) {
            map[word]++;
        } else {
            map[word] = 1;
        }
    }
    return equalMap(map, wordMap);
}

function equalMap(map1, map2) {
    for (const key in map1) {
        if(map1[key] !== map2[key]) {
            return false;
        }
    }
    for(const key in map2) {
        if(map1[key] !== map2[key]) {
            return false;
        }
    }
    return true;
}

