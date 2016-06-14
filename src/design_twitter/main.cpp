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

class Twitter {
public:
  Twitter() {
    /* empty */
  }

  void postTweet(int userId, int tweetId) {
    tweetList[userId].push_back(now);
    timing[now++] = tweetId;
  }

  vector<int> getNewsFeed(int userId) {
    set<int> q;
    followList[userId].emplace(userId);
    for (int followeeId : followList[userId]) {
      for (int orderId : tweetList[followeeId]) {
        q.emplace(orderId);
        if (q.size() > 10) {
          q.erase(q.begin());
        }
      }
    }
    followList[userId].erase(followList[userId].find(userId));
    vector<int> result;
    for (int tweetID : q) {
      result.push_back(timing[tweetID]);
    }
    reverse(result.begin(), result.end());
    return result;
  }

  void follow(int followerId, int followeeId) {
    followList[followerId].emplace(followeeId);
  }

  void unfollow(int followerId, int followeeId) {
    auto iter = followList[followerId].find(followeeId);
    if (iter != followList[followerId].end()) {
      followList[followerId].erase(iter);
    }
  }

private:
  unordered_map<int, unordered_set<int>> followList;
  unordered_map<int, vector<int>> tweetList;
  unordered_map<int, int> timing;
  int now = 0;
};

int main() {
  Twitter obj;
  obj.postTweet(1, 1);
  obj.follow(2, 1);

  for (auto story: obj.getNewsFeed(2)) {
    cout << story << endl;
  }
  return 0;
}
