class 110 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect2
		AttachOn=AM_LA
		EffectClass=Class'LineageEffect.mo_ultimate_defence_cs'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect4
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.mo_ultimate_defence_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect6
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.mo_ultimate_defence_ta'
	End Object
	Desc="얼터미트 디펜스" //Meat Alternate Defense
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect2',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect4',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect6',SpecificStage=0)
}