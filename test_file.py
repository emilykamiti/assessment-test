import pytest
from multiply import product

def test_list_int():
    result = product(2, 3, 6)
    assert result == 36

if __name__ == '__main__':
    pytest.main()
