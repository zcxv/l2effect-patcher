class 279 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect2
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.at_fatal_strike_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect3
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.pm_lightening_strike_ta'
		bOnMultiTarget=True
	End Object
	Desc="라이트닝 스트라이크" //Lightning strike
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect2',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect3',SpecificStage=0)
}