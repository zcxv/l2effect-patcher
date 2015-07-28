class 368 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect55
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.mo_vengence_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect56
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.mo_vengence_ra'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect57
		AttachOn=AM_LH
		AttachBoneName="e_bone"
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.ph_hate_ta'
		bOnMultiTarget=True
	End Object
	Desc="벤젼스" //Vengeance
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect55',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect56',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect57',SpecificStage=0)
}