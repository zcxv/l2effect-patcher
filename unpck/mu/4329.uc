class 4329 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect21
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		bSizeScale=True
		EffectClass=Class'LineageEffect.su_acumen_ta'
		bOnMultiTarget=True
	End Object
	Desc="초보용 아큐멘" //Acumen Beginner
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect21',SpecificStage=0)
}