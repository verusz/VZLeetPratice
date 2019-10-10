//
//  ViewController.swift
//  TwoSum
//
//  Created by 朱继卿 on 2017/12/19.
//  Copyright © 2017年 朱继卿. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var dic =  [Int: Int]()
        for i in 0...nums.count{
            let complement = target - nums[i]
            if dic.keys.contains(complement) {
                return [dic[complement]! , i]
            }
            dic[nums[i]] = i
        }
        fatalError("no accurate answer")
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        print( twoSum([3,3], 6))
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

