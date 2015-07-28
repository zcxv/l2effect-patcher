class 4697 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect18
		AttachOn=AM_RA
		AttachBoneName="e_bone"
		bAbsolute=True
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.ph_hate_ta'
		bOnMultiTarget=True
	End Object
	Desc="NPC Monster Hate" //NPC Monster Hate
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect18',SpecificStage=0)
}