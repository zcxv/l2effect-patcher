class 5009 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect16
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.mp_super_strike_a_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect17
		AttachOn=AM_LH
		AttachBoneName="Bip01 R Finger1"
		EffectClass=Class'LineageEffect.mp_super_strike_a_cs'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect18
		AttachOn=AM_LA
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.at_fatal_strike_ta'
		bOnMultiTarget=True
	End Object
	Desc="유령물리일반" //General Physics ghost
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect16',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect17',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect18',SpecificStage=0)
}