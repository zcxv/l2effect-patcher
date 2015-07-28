class 1264 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect52
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.el_aura_burn_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect53
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.pm_lightening_strike_ta'
		bOnMultiTarget=True
	End Object
	Desc="솔라 스파크" //Solar Spark
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect52',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect53',SpecificStage=0)
}