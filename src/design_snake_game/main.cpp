#include <algorithm>
#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class SnakeGame {
public:
  SnakeGame(int width, int height, vector<pair<int, int>> food) {
    this->width = width;
    this->height = height;
    this->food = food;
    score = 0;
    pos.push_back({0, 0});
  }
    
  int move(string direction) {
    auto head = pos.front(), tail = pos.back();
    pos.pop_back();
    if (direction == "U") {
      --head.first;
    } else if (direction == "L") {
      --head.second;
    } else if (direction == "R") {
      ++head.second;
    } else if (direction == "D") {
      ++head.first;
    }
    if (count(pos.begin(), pos.end(), head) ||
        head.first < 0 ||
        head.first >= height ||
        head.second < 0 ||
        head.second >= width) {
      return -1;
    }
    pos.insert(pos.begin(), head);
    if (!food.empty() && head == food.front()) {
      food.erase(food.begin());
      pos.push_back(tail);
      ++score;
    }
    return score;
  }

private:
  int width, height, score;
  vector<pair<int, int>> food, pos;
};

int main() {

  vector<pair<int, int>> food = {{1, 2}, {0, 1}};

  SnakeGame snake(3, 2, food);
  cout << snake.move("R") << endl;
  cout << snake.move("D") << endl;
  cout << snake.move("R") << endl;
  cout << snake.move("U") << endl;
  cout << snake.move("L") << endl;
  cout << snake.move("U") << endl;

  return 0;
}
