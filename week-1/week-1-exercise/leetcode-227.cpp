#include <stack>
#include <string>
#include <vector>

using namespace std;

inline bool isInteger(const std::string & s)
{
   if(s.empty() || ((!isdigit(s[0])) && (s[0] != '-') && (s[0] != '+'))) return false;

   char * p;
   strtol(s.c_str(), &p, 10);

   return (*p == 0);
}

// How to deal with negative number
// if there are symbol after a symbol like ['+', '-', '(']
// 當遇見 ['+', '-', '(']，set needsZero to true
// 如果符號是 '-' 而且needsZero是true， 在符號前補個零

class Solution {
public:
    int calculate(string s) {
        s += " "; // 最後補空格防止最後數字沒有放tokens裏
        vector<string> tokens;
        string number = "";
        bool needsZero = true;
        for(char ch : s) {
            // 判斷是不是數字
            if(ch >= '0' && ch <= '9') {
                number += ch;
                needsZero = false;
                continue;
            } else {
                // 一個數字已經終止
                if(!number.empty()) {
                    tokens.push_back(number);
                    number = "";
                }
            }
            if(ch == ' ') continue;
            // 括號處理開始
            if(ch == '(') {
                ops.push(ch);
                needsZero = true;
                continue;
            }
            if(ch == ')') {
                while(ops.top() != '(') {
                     tokens.push_back(string(1, ops.top())); 
                     ops.pop();
                }
                ops.pop();
                needsZero = false;
                continue;
            }
            // 括號處理完畢
             if(ch == '-' && needsZero) {
                 tokens.push_back("0");
             }
            int currRank = getRank(ch);
            while(!ops.empty() && getRank(ops.top()) >= currRank) {
                tokens.push_back(string(1, ops.top())); // 
                ops.pop();
            }
            ops.push(ch);
            needsZero = true;
        }
        while(!ops.empty()) {
            tokens.push_back(string(1, ops.top()));
            ops.pop();
        }
        return evalRPN(tokens);
    }
private:
    stack<char> ops;

    int getRank(char ch) {
        if(ch == '*' || ch == '/') return 2;
        if(ch == '+' || ch == '-') return 1;
        return 0;
    }

    int evalRPN(vector<string>& tokens) {
        stack<int> stack1;
        for(int i = 0; i < tokens.size(); i++) {
            if(isInteger(tokens[i])) {
                stack1.push(stoi(tokens[i]));
            } else {
                int firstInt = stack1.top();
                stack1.pop();
                int secondInt = stack1.top();
                stack1.pop();
                int result;
                if(tokens[i] == "+") {
                    result = firstInt + secondInt;
                } else if(tokens[i] == "-") {
                    result = secondInt - firstInt;
                } else if(tokens[i] == "*") {
                    result = secondInt * firstInt;
                } else {
                    result = secondInt / firstInt;
                }
                stack1.push(result);
            }
        }
        return stack1.top();

    }
};