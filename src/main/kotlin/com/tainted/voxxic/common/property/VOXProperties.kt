package com.tainted.voxxic.common.property

import com.google.common.collect.ImmutableList
import net.minecraft.state.property.BooleanProperty
import net.minecraft.state.property.IntProperty
import net.minecraft.util.math.Direction
import net.minecraft.util.math.Direction.*

open class VOXProperties {

    val LEVEL_7: IntProperty = IntProperty.of("level", 0, 7)
    val FLOW_DIRECTION: ImmutableList<Direction> = ImmutableList.of(DOWN, SOUTH, NORTH, EAST, WEST)
    val LAVA_SOAKED: BooleanProperty = BooleanProperty.of("soaked")
}