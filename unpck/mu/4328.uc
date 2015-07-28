class 4328 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect20
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.wh_bless_the_soul_ta'
		bOnMultiTarget=True
	End Object
	Desc="초보용 블레스 더 소울" //Beginner Bless the Soul
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect20',SpecificStage=0)
}