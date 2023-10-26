import unittest
from multiply import product

class TestProduct(unittest.TestCase):
    def test_list_int(self):
        result = product(2, 3, 6)
        self.assertEqual(result, 36)

if __name__ == '__main__':
    unittest.main()
