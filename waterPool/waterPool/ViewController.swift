//
//  ViewController.swift
//  waterPool
//
//  Created by 朱继卿 on 2018/8/20.
//  Copyright © 2018年 tuhu. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        print(trap([0]))
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    func trap(_ height: [Int]) -> Int {
        guard height.count > 2 else { return 0 }
        var ans = 0
        var leftTrap = [Int]()
        leftTrap.append(height[0])
        var rightTrap = [Int].init(repeating: -1, count: height.count)
        for index in 1..<height.count { //从左向右遍历一次从而得到所有右边大于左边高度
            leftTrap.append(max(height[index], leftTrap[index - 1]))
        }
        rightTrap[height.count - 1] = height.last!
        for index in (0..<height.count - 1).reversed() {
            rightTrap[index] = max(height[index], rightTrap[index + 1])
        }
        
        for index in 1..<height.count - 1 {
            ans += min(leftTrap[index], rightTrap[index]) - height[index]
        }
        return ans
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

