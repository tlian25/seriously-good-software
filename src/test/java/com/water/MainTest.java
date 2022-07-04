package com.water;

import com.water.container.Container1Test;
import com.water.container.Container2Test;
import com.water.container.Container3Test;


import org.junit.jupiter.api.RepeatedTest;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;


@SelectPackages({"com.water.container"})
@Suite
public class MainTest {
}
