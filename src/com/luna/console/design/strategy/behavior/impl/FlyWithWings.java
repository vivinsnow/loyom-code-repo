package com.luna.console.design.strategy.behavior.impl;

import com.luna.console.design.strategy.behavior.FlyBehavior;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {

        System.out.println("I'm flying...");
    }

}
