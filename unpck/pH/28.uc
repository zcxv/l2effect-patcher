class 28 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect7
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.ph_hate_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect8
		AttachOn=AM_RA
		AttachBoneName="e_bone"
		bAbsolute=True
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.ph_hate_ta'
		bOnMultiTarget=True
	End Object
	Desc="헤이트" //Hate
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect7',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect8',SpecificStage=0)
}