import pytest


def test_sum(initialize):
    sum=0
    for i in initialize:
        sum=sum+i
    assert sum==55
    print(sum)
