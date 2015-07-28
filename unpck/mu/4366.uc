class 4366 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect15
		AttachOn=AM_LA
		AttachBoneName="e_bone"
		bAbsolute=True
		offset=(X=0.000000,Y=0.000000,Z=1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.ph_hate_ta'
		bOnMultiTarget=True
	End Object
	Desc="박-중독" //Night -poisoning
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect15',SpecificStage=0)
}