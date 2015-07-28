class 4327 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect19
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.su_haste_ta'
		bOnMultiTarget=True
	End Object
	Desc="초보용 헤이스트" //Beginner Heist
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect19',SpecificStage=0)
}