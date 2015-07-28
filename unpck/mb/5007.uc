class 5007 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect25
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_hurricane_ta'
		bOnMultiTarget=True
	End Object
	Desc="프린테사힐억제" //Peurintesa Hill suppression
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect25',SpecificStage=0)
}