class 1181 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect30
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.el_flame_strike_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect31
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.el_flame_strike_pr'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect33
		offset=(X=0.000000,Y=0.000000,Z=1.000000)
		EffectClass=Class'LineageEffect.el_flame_strike_fl'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect32
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_flame_strike_ta'
		bOnMultiTarget=True
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect34
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_flame_strike_ra'
	End Object
	Desc="플레임 스트라이크" //Flame Strike
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect30',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect31',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect33',SpecificStage=0)
	ExplosionActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect32',SpecificStage=0)
	ExplosionActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect34',SpecificStage=0)
	FlyingTime=0.400000
}