class 4365 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect16
		AttachOn=AM_LA
		bSpawnOnTarget=True
		bSizeScale=True
		EffectClass=Class'LineageEffect.su_might_ta'
		bOnMultiTarget=True
	End Object
	Desc="박-렙업" //Night - repeop
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect16',SpecificStage=0)
}