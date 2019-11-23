//
//  ViewController.swift
//  LongestSubstringWithoutRepeatingCharacters
//
//  Created by 朱继卿 on 2017/12/27.
//  Copyright © 2017年 朱继卿. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    func lengthOfLongestSubstring(_ s: String) -> Int {
        guard let lastCh = s.first else {
            return 0
        }
        var str = "\(lastCh)"
        var resultStr = "a"
        for ch in s {
            if str.contains(ch) {
                str = String(str[str.index(after: str.index(of: ch)!)...])
                str.append(ch)
            } else {
                str.append(ch)
                if str.count > resultStr.count {
                    resultStr = str
                    print(resultStr)
                }
            }
        }
        return resultStr.count
    }

    override func viewDidLoad() {
        super.viewDidLoad()
       print(lengthOfLongestSubstring("bpfbhmipx"))
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

