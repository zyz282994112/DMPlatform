import sys
import os
import time
import hashlib
import numpy as np
import matplotlib.pyplot as plt


def SortAndShow(input, output):
    if not os.path.isfile(input):
        return "False"
    if not os.path.isdir(output):
        return "False"

    # Open and read. Get a list imList
    imFileHandle = open(input, "r+")
    imList = imFileHandle.readlines()

    # Use dict store and sort
    dict = []
    sep = "#SUP:"
    for imItem in imList:
        temp = imItem.strip().split(sep)
        print temp
        str = temp[1].strip().split("#CONF:")
        print str
        print temp[0].strip(), float(str[0].strip()), float(str[1].strip())
        dict.append([temp[0].strip(), float(str[0].strip()), float(str[1].strip())])
    sortedDict = sorted(dict, key=lambda e: (e[1]), reverse=True)[0:10]

    key = []
    value = []
    width = 0.5
    dpi = 160
    color = [(.1, .2, .3), (.2, .3, .4), (.3, .4, .5), (.4, .5, .6), (.5, .6, .7), (.6, .7, .8), (.7, .8, .9),
             (.8, .9, 1.0), (.8, .8, .9), (.9, .9, .9)]
    ind = np.arange(10)
    for item in sortedDict:
        key.append(item[0])
        value.append(item[1])

    # Product figure
    plt.figure(figsize=(12, 9), dpi=dpi)
    ax = plt.subplot(111)
    bars = ax.bar(ind, value, width, color=color)
    box = ax.get_position()
    ax.set_position([box.x0, box.y0, box.width * 0.8, box.height])
    plt.title("support")
    plt.xlabel("rank")
    plt.ylabel("support rate")
    plt.xticks(ind + width / 2.,
               ('Rank1', 'Rank2', 'Rank3', 'Rank4', 'Rank5', 'Rank6', 'Rank7', 'Rank8', 'Rank9', 'Rank10'))
    plt.yticks(np.arange(0, 1.1, 0.1))
    plt.legend(bars, key, loc='center left', bbox_to_anchor=(1, 0.5))
    plt.grid()
    m = hashlib.md5("%f" % time.time())
    filename = m.hexdigest() + ".png"
    plt.savefig(output + filename)
    #plt.show()
    print filename


if __name__ == "__main__":
    input = sys.argv[1]
    output = sys.argv[2]
    SortAndShow(input, output)





