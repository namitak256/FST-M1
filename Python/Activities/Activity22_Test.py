import pytest


def test_caladd():
    c=10+20
    print("Sum is:",c)
    assert c==30

def test_calsubs():
    c=30-40
    print("Difference is:",c)
    assert c==-10

@pytest.mark.activity
def test_multiply():
    c=3*4
    print("Product is:",c)
    assert c==12

@pytest.mark.activity
def test_divide():
    c=30/10
    print("Quotient is:",c)
    assert c==3

