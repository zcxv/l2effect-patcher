class 4406 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect31
		AttachOn=AM_LA
		bUseCharacterRotation=True
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.sp_agility_ta'
		bOnMultiTarget=True
	End Object
	Desc="어질리티" //Agility
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect31',SpecificStage=0)
}