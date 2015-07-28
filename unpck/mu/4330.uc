class 4330 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect22
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.su_concentration_ta'
		bOnMultiTarget=True
	End Object
	Desc="초보용 콘센트레이션" //Beginner outlet migration
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect22',SpecificStage=0)
}