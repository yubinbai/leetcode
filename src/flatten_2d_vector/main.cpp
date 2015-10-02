#include <iostream>
#include <map>
#include <vector>
#include <string> 
#include <cstdlib> 

using namespace std;

class Vector2D {
public:
  Vector2D(vector<vector<int>>& vec2d) : vec(vec2d) {
    row = vec.begin();
    if (row != vec.end()) {
      col = row->begin();
      arrange();
    }
  }

  int next() {
    const auto ret = *col;
    ++col;
    arrange();
    return ret;
  }

  bool hasNext() {
    return row != vec.end() && col != row->end();
  }
    
private:
  vector<vector<int>>& vec;
  vector<vector<int>>::iterator row;
  vector<int>::iterator col;

  void arrange() {
    while (row != vec.end() && col == row->end()) { 
      ++row;
      if (row != vec.end()) {
        col = row->begin();
      }
    }
  }

};

int main() {
  vector<vector<int>> vec = {{1, 2}, {3}, {4, 5, 6}};
  Vector2D v2(vec);

  while (v2.hasNext()) {
    cout << v2.next() << endl;
  }
  return 0;
}
