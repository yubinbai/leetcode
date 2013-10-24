'''
Created on May 17, 2013
@author: Yubin Bai
'''


def nextPermutation(seq):
    '''
    permute the sequence in place
    raise error if reached end of permutation
    '''
    size = len(seq)
    if size <= 1:
        return
    # 1.find the first acending order pair from the bottom
    low = size - 2
    high = size - 1
    while seq[low] >= seq[high]:
        if low == high - 1:
            low -= 1
            high = size - 1
            if low < 0:
                break
        else:
            high -= 1

    if low < 0:
        raise Exception("End of permutation")

    # 2.swap num[li] with num[hi] if li >= 0
    seq[low], seq[high] = seq[high], seq[low]
    # 3.reverse i+1 .. end
    k = low + 1
    l = size - 1
    while k < l:
        seq[k], seq[l] = seq[l], seq[k]
        k += 1
        l -= 1

if __name__ == '__main__':
    seq = [1, 2, 2, 3]
    print(seq)
    for i in range(29):
        try:
            nextPermutation(seq)
        except:
            print("End of sequence")
            break
        else:
            print(seq)
