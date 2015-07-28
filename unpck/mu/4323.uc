class 4323 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect11
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.wh_shield_to'
		bOnMultiTarget=True
	End Object
	Desc="초보용 실드" //Beginner shield
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect11',SpecificStage=0)
}