package com.cp.practice;

public class FinancialFunction {
	
	public static void main(String[] args) {
		double val = price(0.378082191780822, 6.25/100, 3.9864/100, 100, 2);
		System.out.println(val);
		
		//coupon=6.25%
		//yield=3.9864
		//redemption=100
		//frequency=2
		//timeToMaturity=0.378082191780822000

		int i=0;
		int sum = 0;
		while(i<100) {
			sum = sum+i;
			sum = i+sum;
			i+=1;
		}
		System.out.println(sum);
		
		System.out.println();
		for(i=1; i<6; i++) {
			System.out.print(t(i) + " ");
		}
		System.out.println();
		System.out.println(fib(6));
		System.out.println(fun(100, 2000));
		System.out.println(100%2000);
		function(100);
	}
	
	static int t(int n) {
		if(n==0||n==1||n==2) {
			return 0;
		}
		if(n==3) {
			return 1;
		} else {
			return t(n-1)+t(n-2) + t(n-3);
		}
	}
	
	static int fib(int n) {
		if(n<=1) {
			return n;
		}
		return fib(n-1) + fib(n-2);
	}
	
	static int fun(int a, int b) {
		if(b==0) {
			return a;
		} else {
			return fun(b, a%b);
		}
	}
	
	public static void function(int n) {
		while(n>0) {
			n++;
			n-=2;
			System.out.println(n);
		}
	}
	
	/**
     * Re-implementation of the Excel PRICE function (a rather primitive bond price formula).
     * The reimplementation is not exact, because this function does not consider daycount conventions.
     * We assume we have (int)timeToMaturity/frequency future periods and the running period has
     * an accrual period of timeToMaturity - frequency * ((int)timeToMaturity/frequency).
     * 
     * @param timeToMaturity The time to maturity.
     * @param coupon Coupon payment.
     * @param yield Yield (discount factor, using frequency: 1/(1 + yield/frequency).
     * @param redemption Redemption (notional repayment).
     * @param frequency Frequency (1,2,4).
     * @return price Clean price.
     */
    public static double price(
            double timeToMaturity,
            double coupon,
            double yield,
            double redemption,
            int frequency)
    {
        double price = 0.0;

        if(timeToMaturity > 0) {
            price += redemption;
        }

        double paymentTime = timeToMaturity;
        while(paymentTime > 0) {
            price += coupon/frequency;

            // Discount back
            price = price / (1.0 + yield / frequency);
            paymentTime -= 1.0 / frequency;
        }

        // Accrue running period
        double accrualPeriod = 0.0-paymentTime; // amount of running period which lies in the past (before settlement)
        price *= Math.pow(1.0 + yield / frequency, accrualPeriod*frequency);
        price -= coupon/frequency * accrualPeriod*frequency;

        return price;
    }
}
