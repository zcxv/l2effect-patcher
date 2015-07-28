class 4548 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect6
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect7
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.wh_recharge_ta'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect8
		AttachOn=AM_LA
		offset=(X=6.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.wh_recharge_ta'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect9
		AttachOn=AM_LA
		offset=(X=-5.000000,Y=6.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.wh_recharge_ta'
	End Object
	Desc="Quest 감시자의 시선 해제" //Quest 's eyes off the monitor
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect6',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect7',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect8',SpecificStage=0)
	ShotActions(2)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect9',SpecificStage=0)
}