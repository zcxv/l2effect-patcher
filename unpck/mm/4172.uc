class 4172 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect26
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.s_u804_a_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect27
		offset=(X=-2.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.s_u804_a_ta'
	End Object
	Desc="쇼크" //Shock
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect26',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect27',SpecificStage=0)
}