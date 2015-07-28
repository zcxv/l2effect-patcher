class 2031 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect6
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.it_healing_potion_ta'
	End Object
	Desc="체력회복제" //Health poultices
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect6',SpecificStage=0)
}