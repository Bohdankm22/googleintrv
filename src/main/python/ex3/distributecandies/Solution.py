class Solution(object):
    @staticmethod
    def distribute_candies(candies):
        """
        :type candies: List[int]
        :rtype: int
        """
        numbers = set(candies)
        if len(candies) / 2 > len(numbers):
            return len(numbers)
        else:
            return len(candies) / 2


def main():
    sol = Solution()
    print sol.distribute_candies([1, 1, 2, 3])


if __name__ == '__main__':
    main()
