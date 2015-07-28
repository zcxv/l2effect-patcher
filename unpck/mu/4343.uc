class 4343 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect3
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.su_detection_ta'
		bOnMultiTarget=True
	End Object
	Desc="아지트 디크리즈 웨이트" //Ajit D. Crease weight
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect3',SpecificStage=0)
}