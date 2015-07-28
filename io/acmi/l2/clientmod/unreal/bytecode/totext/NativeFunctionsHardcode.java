/*
 * Copyright (c) 2014 acmi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package acmi.l2.clientmod.unreal.bytecode.totext;

import acmi.l2.clientmod.unreal.UnrealException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class NativeFunctionsHardcode implements NativeFunctionsSupplier {
    private static final Map<Integer, NativeFunction> NATIVE_FUNCTIONS = new HashMap<>();

    static {
        registerNativeFunction(new NativeFunction(112, "$", false, 40, true));
        registerNativeFunction(new NativeFunction(113, "GotoState", false, 0, false));
        registerNativeFunction(new NativeFunction(114, "==", false, 24, true));
        registerNativeFunction(new NativeFunction(115, "<", false, 24, true));
        registerNativeFunction(new NativeFunction(116, ">", false, 24, true));
        registerNativeFunction(new NativeFunction(117, "Enable", false, 0, false));
        registerNativeFunction(new NativeFunction(118, "Disable", false, 0, false));
        registerNativeFunction(new NativeFunction(119, "!=", false, 26, true));
        registerNativeFunction(new NativeFunction(120, "<=", false, 24, true));
        registerNativeFunction(new NativeFunction(121, ">=", false, 24, true));
        registerNativeFunction(new NativeFunction(122, "==", false, 24, true));
        registerNativeFunction(new NativeFunction(123, "!=", false, 26, true));
        registerNativeFunction(new NativeFunction(124, "~=", false, 24, true));
        registerNativeFunction(new NativeFunction(125, "Len", false, 0, false));
        registerNativeFunction(new NativeFunction(126, "InStr", false, 0, false));
        registerNativeFunction(new NativeFunction(127, "Mid", false, 0, false));
        registerNativeFunction(new NativeFunction(128, "Left", false, 0, false));
        registerNativeFunction(new NativeFunction(129, "!", true, 0, true));
        registerNativeFunction(new NativeFunction(130, "&&", false, 30, true));
        registerNativeFunction(new NativeFunction(131, "^^", false, 30, true));
        registerNativeFunction(new NativeFunction(132, "||", false, 32, true));
        registerNativeFunction(new NativeFunction(133, "*=", false, 34, true));
        registerNativeFunction(new NativeFunction(134, "/=", false, 34, true));
        registerNativeFunction(new NativeFunction(135, "+=", false, 34, true));
        registerNativeFunction(new NativeFunction(136, "-=", false, 34, true));
        registerNativeFunction(new NativeFunction(137, "++", true, 0, true));
        registerNativeFunction(new NativeFunction(138, "--", true, 0, true));
        registerNativeFunction(new NativeFunction(139, "++", false, 0, true));
        registerNativeFunction(new NativeFunction(140, "--", false, 0, true));
        registerNativeFunction(new NativeFunction(141, "~", true, 0, true));
        registerNativeFunction(new NativeFunction(142, "==", false, 24, true));
        registerNativeFunction(new NativeFunction(143, "-", true, 0, true));
        registerNativeFunction(new NativeFunction(144, "*", false, 16, true));
        registerNativeFunction(new NativeFunction(145, "/", false, 16, true));
        registerNativeFunction(new NativeFunction(146, "+", false, 20, true));
        registerNativeFunction(new NativeFunction(147, "-", false, 20, true));
        registerNativeFunction(new NativeFunction(148, "<<", false, 22, true));
        registerNativeFunction(new NativeFunction(149, ">>", false, 22, true));
        registerNativeFunction(new NativeFunction(150, "<", false, 24, true));
        registerNativeFunction(new NativeFunction(151, ">", false, 24, true));
        registerNativeFunction(new NativeFunction(152, "<=", false, 24, true));
        registerNativeFunction(new NativeFunction(153, ">=", false, 24, true));
        registerNativeFunction(new NativeFunction(154, "==", false, 24, true));
        registerNativeFunction(new NativeFunction(155, "!=", false, 26, true));
        registerNativeFunction(new NativeFunction(156, "&", false, 28, true));
        registerNativeFunction(new NativeFunction(157, "^", false, 28, true));
        registerNativeFunction(new NativeFunction(158, "|", false, 28, true));
        registerNativeFunction(new NativeFunction(159, "*=", false, 34, true));
        registerNativeFunction(new NativeFunction(160, "/=", false, 34, true));
        registerNativeFunction(new NativeFunction(161, "+=", false, 34, true));
        registerNativeFunction(new NativeFunction(162, "-=", false, 34, true));
        registerNativeFunction(new NativeFunction(163, "++", true, 0, true));
        registerNativeFunction(new NativeFunction(164, "--", true, 0, true));
        registerNativeFunction(new NativeFunction(165, "++", false, 0, true));
        registerNativeFunction(new NativeFunction(166, "--", false, 0, true));
        registerNativeFunction(new NativeFunction(167, "Rand", false, 0, false));
        registerNativeFunction(new NativeFunction(168, "@", false, 40, true));
        registerNativeFunction(new NativeFunction(169, "-", true, 0, true));
        registerNativeFunction(new NativeFunction(170, "**", false, 12, true));
        registerNativeFunction(new NativeFunction(171, "*", false, 16, true));
        registerNativeFunction(new NativeFunction(172, "/", false, 16, true));
        registerNativeFunction(new NativeFunction(173, "%", false, 18, true));
        registerNativeFunction(new NativeFunction(174, "+", false, 20, true));
        registerNativeFunction(new NativeFunction(175, "-", false, 20, true));
        registerNativeFunction(new NativeFunction(176, "<", false, 24, true));
        registerNativeFunction(new NativeFunction(177, ">", false, 24, true));
        registerNativeFunction(new NativeFunction(178, "<=", false, 24, true));
        registerNativeFunction(new NativeFunction(179, ">=", false, 24, true));
        registerNativeFunction(new NativeFunction(180, "==", false, 24, true));
        registerNativeFunction(new NativeFunction(181, "!=", false, 26, true));
        registerNativeFunction(new NativeFunction(182, "*=", false, 34, true));
        registerNativeFunction(new NativeFunction(183, "/=", false, 34, true));
        registerNativeFunction(new NativeFunction(184, "+=", false, 34, true));
        registerNativeFunction(new NativeFunction(185, "-=", false, 34, true));
        registerNativeFunction(new NativeFunction(186, "Abs", false, 0, false));
        registerNativeFunction(new NativeFunction(187, "Sin", false, 0, false));
        registerNativeFunction(new NativeFunction(188, "Cos", false, 0, false));
        registerNativeFunction(new NativeFunction(189, "Tan", false, 0, false));
        registerNativeFunction(new NativeFunction(190, "Atan", false, 0, false));
        registerNativeFunction(new NativeFunction(191, "Exp", false, 0, false));
        registerNativeFunction(new NativeFunction(192, "Loge", false, 0, false));
        registerNativeFunction(new NativeFunction(193, "Sqrt", false, 0, false));
        registerNativeFunction(new NativeFunction(194, "Square", false, 0, false));
        registerNativeFunction(new NativeFunction(195, "FRand", false, 0, false));
        registerNativeFunction(new NativeFunction(196, ">>>", false, 22, true));
        registerNativeFunction(new NativeFunction(197, "*", false, 16, true));
        registerNativeFunction(new NativeFunction(203, "!=", false, 26, true));
        registerNativeFunction(new NativeFunction(210, "~=", false, 24, true));
        registerNativeFunction(new NativeFunction(211, "-", true, 0, true));
        registerNativeFunction(new NativeFunction(212, "*", false, 16, true));
        registerNativeFunction(new NativeFunction(213, "*", false, 16, true));
        registerNativeFunction(new NativeFunction(214, "/", false, 16, true));
        registerNativeFunction(new NativeFunction(215, "+", false, 20, true));
        registerNativeFunction(new NativeFunction(216, "-", false, 20, true));
        registerNativeFunction(new NativeFunction(217, "==", false, 24, true));
        registerNativeFunction(new NativeFunction(218, "!=", false, 26, true));
        registerNativeFunction(new NativeFunction(219, "Dot", false, 16, true));
        registerNativeFunction(new NativeFunction(220, "Cross", false, 16, true));
        registerNativeFunction(new NativeFunction(221, "*=", false, 34, true));
        registerNativeFunction(new NativeFunction(222, "/=", false, 34, true));
        registerNativeFunction(new NativeFunction(223, "+=", false, 34, true));
        registerNativeFunction(new NativeFunction(224, "-=", false, 34, true));
        registerNativeFunction(new NativeFunction(225, "VSize", false, 0, false));
        registerNativeFunction(new NativeFunction(226, "Normal", false, 0, false));
        registerNativeFunction(new NativeFunction(227, "Invert", false, 0, false));
        registerNativeFunction(new NativeFunction(229, "GetAxes", false, 0, false));
        registerNativeFunction(new NativeFunction(230, "GetUnAxes", false, 0, false));
        registerNativeFunction(new NativeFunction(231, "Log", false, 0, false));
        registerNativeFunction(new NativeFunction(232, "Warn", false, 0, false));
        registerNativeFunction(new NativeFunction(233, "Error", false, 0, false));
        registerNativeFunction(new NativeFunction(234, "Right", false, 0, false));
        registerNativeFunction(new NativeFunction(235, "Caps", false, 0, false));
        registerNativeFunction(new NativeFunction(236, "Chr", false, 0, false));
        registerNativeFunction(new NativeFunction(237, "Asc", false, 0, false));
        registerNativeFunction(new NativeFunction(238, "Substitute", false, 0, false));
        registerNativeFunction(new NativeFunction(242, "==", false, 24, true));
        registerNativeFunction(new NativeFunction(243, "!=", false, 26, true));
        registerNativeFunction(new NativeFunction(244, "FMin", false, 0, false));
        registerNativeFunction(new NativeFunction(245, "FMax", false, 0, false));
        registerNativeFunction(new NativeFunction(246, "FClamp", false, 0, false));
        registerNativeFunction(new NativeFunction(247, "Lerp", false, 0, false));
        registerNativeFunction(new NativeFunction(248, "Smerp", false, 0, false));
        registerNativeFunction(new NativeFunction(249, "Min", false, 0, false));
        registerNativeFunction(new NativeFunction(250, "Max", false, 0, false));
        registerNativeFunction(new NativeFunction(251, "Clamp", false, 0, false));
        registerNativeFunction(new NativeFunction(252, "VRand", false, 0, false));
        registerNativeFunction(new NativeFunction(254, "==", false, 24, true));
        registerNativeFunction(new NativeFunction(255, "!=", false, 26, true));
        registerNativeFunction(new NativeFunction(256, "Sleep", false, 0, false));
        registerNativeFunction(new NativeFunction(258, "ClassIsChildOf", false, 0, false));
        registerNativeFunction(new NativeFunction(259, "PlayAnim", false, 0, false));
        registerNativeFunction(new NativeFunction(260, "LoopAnim", false, 0, false));
        registerNativeFunction(new NativeFunction(261, "FinishAnim", false, 0, false));
        registerNativeFunction(new NativeFunction(262, "SetCollision", false, 0, false));
        registerNativeFunction(new NativeFunction(263, "HasAnim", false, 0, false));
        registerNativeFunction(new NativeFunction(264, "PlaySound", false, 0, false));
        registerNativeFunction(new NativeFunction(266, "Move", false, 0, false));
        registerNativeFunction(new NativeFunction(267, "SetLocation", false, 0, false));
        registerNativeFunction(new NativeFunction(272, "SetOwner", false, 0, false));
        registerNativeFunction(new NativeFunction(275, "<<", false, 22, true));
        registerNativeFunction(new NativeFunction(276, ">>", false, 22, true));
        registerNativeFunction(new NativeFunction(277, "Trace", false, 0, false));
        registerNativeFunction(new NativeFunction(278, "Spawn", false, 0, false));
        registerNativeFunction(new NativeFunction(279, "Destroy", false, 0, false));
        registerNativeFunction(new NativeFunction(280, "SetTimer", false, 0, false));
        registerNativeFunction(new NativeFunction(281, "IsInState", false, 0, false));
        registerNativeFunction(new NativeFunction(282, "IsAnimating", false, 0, false));
        registerNativeFunction(new NativeFunction(283, "SetCollisionSize", false, 0, false));
        registerNativeFunction(new NativeFunction(284, "GetStateName", false, 0, false));
        registerNativeFunction(new NativeFunction(287, "*", false, 16, true));
        registerNativeFunction(new NativeFunction(288, "*", false, 16, true));
        registerNativeFunction(new NativeFunction(289, "/", false, 16, true));
        registerNativeFunction(new NativeFunction(290, "*=", false, 34, true));
        registerNativeFunction(new NativeFunction(291, "/=", false, 34, true));
        registerNativeFunction(new NativeFunction(294, "TweenAnim", false, 0, false));
        registerNativeFunction(new NativeFunction(296, "*", false, 16, true));
        registerNativeFunction(new NativeFunction(297, "*=", false, 34, true));
        registerNativeFunction(new NativeFunction(298, "SetBase", false, 0, false));
        registerNativeFunction(new NativeFunction(299, "SetRotation", false, 0, false));
        registerNativeFunction(new NativeFunction(300, "MirrorVectorByNormal", false, 0, false));
        registerNativeFunction(new NativeFunction(301, "FinishInterpolation", false, 0, false));
        registerNativeFunction(new NativeFunction(303, "IsA", false, 0, false));
        registerNativeFunction(new NativeFunction(304, "AllActors", false, 0, false));
        registerNativeFunction(new NativeFunction(305, "ChildActors", false, 0, false));
        registerNativeFunction(new NativeFunction(306, "BasedActors", false, 0, false));
        registerNativeFunction(new NativeFunction(307, "TouchingActors", false, 0, false));
        registerNativeFunction(new NativeFunction(308, "ZoneActors", false, 0, false));
        registerNativeFunction(new NativeFunction(309, "TraceActors", false, 0, false));
        registerNativeFunction(new NativeFunction(310, "RadiusActors", false, 0, false));
        registerNativeFunction(new NativeFunction(311, "VisibleActors", false, 0, false));
        registerNativeFunction(new NativeFunction(312, "VisibleCollidingActors", false, 0, false));
        registerNativeFunction(new NativeFunction(313, "DynamicActors", false, 0, false));
        registerNativeFunction(new NativeFunction(314, "Warp", false, 0, false));
        registerNativeFunction(new NativeFunction(315, "UnWarp", false, 0, false));
        registerNativeFunction(new NativeFunction(316, "+", false, 20, true));
        registerNativeFunction(new NativeFunction(317, "-", false, 20, true));
        registerNativeFunction(new NativeFunction(318, "+=", false, 34, true));
        registerNativeFunction(new NativeFunction(319, "-=", false, 34, true));
        registerNativeFunction(new NativeFunction(320, "RotRand", false, 0, false));
        registerNativeFunction(new NativeFunction(321, "CollidingActors", false, 0, false));
        registerNativeFunction(new NativeFunction(400, "-", true, 0, true));
        registerNativeFunction(new NativeFunction(401, "*", false, 16, true));
        registerNativeFunction(new NativeFunction(402, "*", false, 16, true));
        registerNativeFunction(new NativeFunction(403, "/", false, 16, true));
        registerNativeFunction(new NativeFunction(404, "+", false, 20, true));
        registerNativeFunction(new NativeFunction(405, "-", false, 20, true));
        registerNativeFunction(new NativeFunction(406, "+=", false, 34, true));
        registerNativeFunction(new NativeFunction(407, "-=", false, 34, true));
        registerNativeFunction(new NativeFunction(408, "<", false, 24, true));
        registerNativeFunction(new NativeFunction(409, ">", false, 24, true));
        registerNativeFunction(new NativeFunction(410, "<=", false, 24, true));
        registerNativeFunction(new NativeFunction(411, ">=", false, 24, true));
        registerNativeFunction(new NativeFunction(412, "==", false, 24, true));
        registerNativeFunction(new NativeFunction(413, "!=", false, 26, true));
        registerNativeFunction(new NativeFunction(464, "StrLen", false, 0, false));
        registerNativeFunction(new NativeFunction(465, "DrawText", false, 0, false));
        registerNativeFunction(new NativeFunction(466, "DrawTile", false, 0, false));
        registerNativeFunction(new NativeFunction(467, "DrawActor", false, 0, false));
        registerNativeFunction(new NativeFunction(468, "DrawTileClipped", false, 0, false));
        registerNativeFunction(new NativeFunction(469, "DrawTextClipped", false, 0, false));
        registerNativeFunction(new NativeFunction(470, "TextSize", false, 0, false));
        registerNativeFunction(new NativeFunction(480, "DrawPortal", false, 0, false));
        registerNativeFunction(new NativeFunction(500, "MoveTo", false, 0, false));
        registerNativeFunction(new NativeFunction(502, "MoveToward", false, 0, false));
        registerNativeFunction(new NativeFunction(508, "FinishRotation", false, 0, false));
        registerNativeFunction(new NativeFunction(510, "WaitToSeeEnemy", false, 0, false));
        registerNativeFunction(new NativeFunction(512, "MakeNoise", false, 0, false));
        registerNativeFunction(new NativeFunction(514, "LineOfSightTo", false, 0, false));
        registerNativeFunction(new NativeFunction(517, "FindPathToward", false, 0, false));
        registerNativeFunction(new NativeFunction(518, "FindPathTo", false, 0, false));
        registerNativeFunction(new NativeFunction(520, "actorReachable", false, 0, false));
        registerNativeFunction(new NativeFunction(521, "pointReachable", false, 0, false));
        registerNativeFunction(new NativeFunction(523, "EAdjustJump", false, 0, false));
        registerNativeFunction(new NativeFunction(524, "FindStairRotation", false, 0, false));
        registerNativeFunction(new NativeFunction(525, "FindRandomDest", false, 0, false));
        registerNativeFunction(new NativeFunction(526, "PickWallAdjust", false, 0, false));
        registerNativeFunction(new NativeFunction(527, "WaitForLanding", false, 0, false));
        registerNativeFunction(new NativeFunction(529, "AddController", false, 0, false));
        registerNativeFunction(new NativeFunction(530, "RemoveController", false, 0, false));
        registerNativeFunction(new NativeFunction(531, "PickTarget", false, 0, false));
        registerNativeFunction(new NativeFunction(532, "PlayerCanSeeMe", false, 0, false));
        registerNativeFunction(new NativeFunction(533, "CanSee", false, 0, false));
        registerNativeFunction(new NativeFunction(534, "PickAnyTarget", false, 0, false));
        registerNativeFunction(new NativeFunction(536, "SaveConfig", false, 0, false));
        registerNativeFunction(new NativeFunction(539, "GetMapName", false, 0, false));
        registerNativeFunction(new NativeFunction(540, "FindBestInventoryPath", false, 0, false));
        registerNativeFunction(new NativeFunction(544, "ResetKeyboard", false, 0, false));
        registerNativeFunction(new NativeFunction(545, "GetNextSkin", false, 0, false));
        registerNativeFunction(new NativeFunction(546, "UpdateURL", false, 0, false));
        registerNativeFunction(new NativeFunction(547, "GetURLMap", false, 0, false));
        registerNativeFunction(new NativeFunction(548, "FastTrace", false, 0, false));
        registerNativeFunction(new NativeFunction(549, "-", false, 20, true));
        registerNativeFunction(new NativeFunction(550, "*", false, 16, true));
        registerNativeFunction(new NativeFunction(551, "+", false, 20, true));
        registerNativeFunction(new NativeFunction(552, "*", false, 16, true));
        registerNativeFunction(new NativeFunction(3969, "MoveSmooth", false, 0, false));
        registerNativeFunction(new NativeFunction(3970, "SetPhysics", false, 0, false));
        registerNativeFunction(new NativeFunction(3971, "AutonomousPhysics", false, 0, false));
    }

    private static void registerNativeFunction(NativeFunction function) {
        NATIVE_FUNCTIONS.put(function.getIndex(), function);
    }

    @Override
    public NativeFunction apply(Integer integer) throws UnrealException {
        return Optional.ofNullable(NATIVE_FUNCTIONS.get(integer)).orElseThrow(() -> new UnrealException(String.format("Native function (%d) not found", integer)));
    }
}
