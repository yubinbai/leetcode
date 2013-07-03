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
    # find the largest i than can be increased
    i = size - 2
    while i != 0 and seq[i] > seq[i + 1]:
        i -= 1

    if i == 0 and seq[i] > seq[i + 1]:
        raise Exception("End of permutation")
    # increase seq[i] by the smallest amount
    # a[j+1] > a[j+1] > ... a[n-1]
    l = size - 1
    while seq[l] < seq[i]:
        l -= 1
    seq[l], seq[i] = seq[i], seq[l]
    # reverse i+1 .. end
    k = i + 1
    l = size - 1
    while k < l:
        seq[k], seq[l] = seq[l], seq[k]
        k += 1
        l -= 1

if __name__ == '__main__':
    seq = [1, 2, 3, 4]
    print(seq)
    for i in range(29):
        try:
            nextPermutation(seq)
        except:
            print("End of sequence")
            break
        else:
            print(seq)
