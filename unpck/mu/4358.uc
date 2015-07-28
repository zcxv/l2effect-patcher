class 4358 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect32
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.su_guidance_ta'
		bOnMultiTarget=True
	End Object
	Desc="아지트 가이던스" //Ajit guidance
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect32',SpecificStage=0)
}