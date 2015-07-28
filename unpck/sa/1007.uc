class 1007 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect20
		AttachOn=AM_LA
		offset=(X=1.000000,Y=0.000000,Z=0.000000)
		EffectClass=Class'LineageEffect.sa_mass_frenzy_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect21
		AttachOn=AM_LA
		EffectClass=Class'LineageEffect.sa_mass_frenzy_cs'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect22
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.sa_mass_frenzy_ta'
		bOnMultiTarget=True
	End Object
	Desc="매스 프렌지" //Mass Frenzy
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect20',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect21',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect22',SpecificStage=0)
}