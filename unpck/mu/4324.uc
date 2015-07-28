class 4324 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect12
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.wh_bless_the_body_ta'
		bOnMultiTarget=True
	End Object
	Desc="초보용 블레스 더 바디" //Beginner Bless The Body
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect12',SpecificStage=0)
}