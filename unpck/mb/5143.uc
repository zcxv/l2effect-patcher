class 5143 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect48
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-70.000000)
		bRelativeToCylinder=False
		EffectClass=Class'LineageEffect.e_u832_new_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect49
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.s_u804_a_ta'
		bOnMultiTarget=True
	End Object
	Desc="사이렌전용블로우" //Siren -only blow
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect48',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect49',SpecificStage=0)
}